package xyz.walk8243.athleticstool.repositoryapi.domain.exception;

import java.util.NoSuchElementException;

public class NoDataException extends NoSuchElementException {

	public NoDataException() {
		this("対象のデータがありませんでした。");
	}

	public NoDataException(String message) {
		super(message);
	}

	@Override
	public String getMessage() {
		return "[%s] %s のデータがありません。".formatted(this.getClass().getSimpleName(), super.getMessage());
	}
}
