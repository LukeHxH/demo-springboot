package com.example.lukehxh.demo.exceptions;

@SuppressWarnings("unused")
public class ValidationErrorDetails extends ErrorDetails {

    private String field;
    private String fieldMessage;

    public String getField() {
        return field;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public static final class Builder {
        private String title;
        private int status;
        private String details;
        private long timestamp;
        private String devMessage;
        private String field;
        private String fieldMessage;

        private Builder() {
        }

        public static Builder newBuilder() {
            return new Builder();
        }

        public Builder title(String title) {
            this.title = title;
            return this;
        }

        public Builder status(int status) {
            this.status = status;
            return this;
        }

        public Builder details(String details) {
            this.details = details;
            return this;
        }

        public Builder timestamp(long timestamp) {
            this.timestamp = timestamp;
            return this;
        }

        public Builder message(String message) {
            this.devMessage = message;
            return this;
        }

        public Builder field(String field) {
            this.field = field;
            return this;
        }

        public Builder fieldMessage(String fieldMessage) {
            this.fieldMessage = fieldMessage;
            return this;
        }

        @SuppressWarnings("Duplicates")
        public ValidationErrorDetails build() {
            ValidationErrorDetails validationErrorDetails = new ValidationErrorDetails();
            validationErrorDetails.setTimestamp(this.timestamp);
            validationErrorDetails.setDevMessage(this.devMessage);
            validationErrorDetails.setDetails(this.details);
            validationErrorDetails.setTitle(this.title);
            validationErrorDetails.setStatus(this.status);
            validationErrorDetails.field = this.field;
            validationErrorDetails.fieldMessage = this.fieldMessage;

            return validationErrorDetails;
        }
    }
}
