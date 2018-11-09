package org.seckill.exception;

import org.seckill.dto.SeckillExecution;

/**
 * 秒杀相关业务异常
 */

public class SeckillException extends RuntimeException {

    public SeckillException(String message) {
        super(message);
    }

    public SeckillException(String message, Throwable cause) {
        super(message, cause);
    }
}
