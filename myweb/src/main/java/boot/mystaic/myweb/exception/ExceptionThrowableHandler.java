package boot.mystaic.myweb.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *  *
 *  * The class ExceptionThrowableHandler.
 *  *
 *  * Description:有些异常会向高级别异常传递（但ArithmeticException不会向Exception传送）
 *  *
 *  * @author:
 *  * @since: 2019年11月25日
 *  * @version: $Revision$ $Date$ $LastChangedBy$
 *  *
 *  
 */
@ControllerAdvice(value = {"boot.mystaic.myweb.controller.*","boot.mystaic.myweb.secret.*"},annotations = {Controller.class,RestController.class, Service.class})
@RestController
@Slf4j
public class ExceptionThrowableHandler {
    @ExceptionHandler(Throwable.class)
    public ErrorReturn dealThrowable() {
        ErrorReturn error = new ErrorReturn();
        error.setDesc("处理Throwable!");
        error.setReturnCode("-1");
        return error;
    }

    @ExceptionHandler(Exception.class)
    public ErrorReturn dealCommonException() {
        ErrorReturn error = new ErrorReturn();
        error.setReturnCode("-1");
        error.setDesc("公共异常处理！");
        return error;
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String,Object> UsernameNotfoundException(HttpServletRequest request,UsernameNotFoundException e){
        Map<String, Object> msgMap = new HashMap<>();
        msgMap.put("code", 3333);
        msgMap.put("message",e.getMessage());
        log.error(e.getMessage());
        return msgMap;
    }


}
