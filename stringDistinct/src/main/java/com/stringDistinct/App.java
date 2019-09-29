package com.stringDistinct;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.RecursiveAction;


/**
 * Hello world!
 */
@Slf4j
public class App {
    final static private String filepath2 = "f:\\Normalized Software_Downer_apj_1.xlsx";
    final static private String filepath = "f:\\测试数据.xlsx";

    public static void main(String[] args) {
        int count = 1000_0000;
        tt(count);
    }

    static void tt(int count) {
        Random r = new Random();
        int showNo = r.nextInt(count);
        double[] nums = new double[count];
        double[] num2 = new double[count];
        for (int i = 0; i < count; i++) {
            nums[i] = (double) i;
            num2[i] = (double) i;
        }
        Transform tf = new Transform(1000, nums, 0, count);
        long start1 = System.currentTimeMillis();
        tf.invoke();
        long end1 = System.currentTimeMillis();
        double[] n2 = Arrays.stream(num2).parallel().map(n ->cc(n)).toArray();
        long end2 = System.currentTimeMillis();
        log.info("用时：{}", end1 - start1);
        log.info("用时：{}", end2 - end1);
        log.info("{},原:   {}", showNo, num2[showNo]);
        log.info("{},5:    {}", showNo, nums[showNo]);
        log.info("{},5-2:  {}", showNo, n2[showNo]);
    }

    static double cc(double d) {
      return  Math.pow(Math.round( Math.sin( Math.sqrt(d))*100),Math.PI);
    }

    static class Transform extends RecursiveAction {
        int seqThreshold;
        double[] data;
        int start, end;

        protected Transform(int seqThreshold, double[] data, int start, int end) {
            this.seqThreshold = seqThreshold;
            this.data = data;
            this.start = start;
            this.end = end;
        }

        @Override
        protected void compute() {
            if ((end - start) < seqThreshold) {
                for (int i = start; i < end; i++) {
                    data[i] = cc(i);
//                    if ((data[i] % 2) == 0) data[i] = Math.sqrt(data[i]);
//                    else data[i] = Math.cbrt(data[i]);
                }
            } else {
                int middle = (start + end) / 2;
                invokeAll(new Transform(seqThreshold, data, start, middle),
                        new Transform(seqThreshold, data, middle, end));
            }
        }
    }
}
