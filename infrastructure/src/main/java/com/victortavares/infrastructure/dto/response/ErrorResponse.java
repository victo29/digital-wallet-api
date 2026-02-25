package com.victortavares.infrastructure.dto.response;

import java.util.List;

public record ErrorResponse( String message, String code, List<ValidationError> validations){}
