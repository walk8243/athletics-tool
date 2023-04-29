package xyz.walk8243.athleticstool.repositoryapi.presentation.advice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import lombok.extern.slf4j.Slf4j;
import xyz.walk8243.athleticstool.entity.domain.exception.NoDataException;

@Slf4j
@RestControllerAdvice
public class ErrorHandlerController {
	
	@ExceptionHandler({ NoDataException.class })
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public ErrorResponse handleNoDataException(NoDataException ex) {
		log.warn(ex.getMessage());
        return new ErrorResponse(HttpStatus.NOT_FOUND);
	}

	public record ErrorResponse(
		String code,
    	String message
	) {

		public ErrorResponse(HttpStatus httpStatus) {
			this(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase());
		}
	}
}
