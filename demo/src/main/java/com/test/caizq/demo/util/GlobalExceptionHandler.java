package com.test.caizq.demo.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.test.caizq.demo.entity.JsonResult;


@ControllerAdvice
@ResponseBody  //异常处理完之后给调用方输出一个 json 格式的封装数据
public class GlobalExceptionHandler {
	
	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public JsonResult<Object> handleTypeMismatchException(NullPointerException ex) {
		logger.error("空指针异常，{}", ex.getMessage());
		return new JsonResult<Object>("501","空指针异常");
		
	}
	
	//先处理上面的异常，上面处理不了才由最下面的来捕获
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value=HttpStatus.INTERNAL_SERVER_ERROR)
	public JsonResult<Object> handleUnexpectedException(Exception ex){
		logger.error("有exception,{}",ex.getMessage());
		return new JsonResult<Object>("500",ex.getMessage());
	}
	
}
