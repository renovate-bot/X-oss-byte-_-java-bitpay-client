/*
 * Copyright (c) 2019 BitPay.
 * All rights reserved.
 */

package com.bitpay.sdk.exceptions;

/**
 * Exception which is extended by other exceptions related with Currency.
 *
 * @see com.bitpay.sdk.exceptions.CurrencyQueryException
 * @see <a href="https://bitpay.readme.io/reference/error-codes">Rest API Error Codes</a>
 */
public class CurrencyException extends BitPayException {
    /**
     * Construct the CurrencyException.
     *
     * @param status String [optional] The Exception code to throw.
     * @param message String [optional] The Exception message to throw.
     */
    public CurrencyException(
        String status,
        String message
    ) {
        super(status, buildMessage(message));
    }

    private static String buildMessage(String message) {
        String bitPayMessage = "An unexpected error occurred while trying to manage the currencies";
        String bitPayCode = "BITPAY-CURRENCY-GENERIC";

        if (message.isEmpty() || !message.contains("BITPAY-")) {
            message = bitPayCode + ": " + bitPayMessage + " -> " + message;
        }

        return message;
    }
}
