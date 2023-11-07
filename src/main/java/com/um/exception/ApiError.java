package com.um.exception;

public record ApiError(int status, String message, String developerMessage) {

}
