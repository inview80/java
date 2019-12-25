package boot.mystaic.myweb.exception;

import lombok.Data;

@Data
public class ErrorReturn {
    private String desc;
    private String ReturnCode;
}
