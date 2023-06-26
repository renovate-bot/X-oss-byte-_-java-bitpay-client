/*
 * Copyright (c) 2019 BitPay.
 * All rights reserved.
 */

package com.bitpay.sdk.exceptions;

/**
 * <p>
 * Exception thrown for a PUT when the Invoice cannot be updated.
 * </p>
 * <ul>
 *   <li>First two digits: HTTP method</li>
 *   <li>Second two digits: Resource</li>
 *   <li>Final two digits: Error</li>
 * </ul>
 * <p>HTTP method digits for this class: 03</p>
 * <p>Resource digits for the Invoice: 01</p>
 * <p>Error digits for the Invoice:</p>
 * <ul>
 *     <li>00 - Generic server error</li>
 *     <li>01 - Resource not found</li>
 *     <li>02 - Invalid parameters</li>
 *     <li>03 - Missing parameters</li>
 *     <li>08 - Invoice is missing email or SMS</li>
 *     <li>09 - SMS not verified</li>
 *     <li>10 - Invoice price is below minimum threshold</li>
 *     <li>11 - Invoice price is above maximum threshold</li>
 *     <li>12 - Invalid SMS number</li>
 *     <li>13 - Error verifying SMS</li>
 *     <li>14 - Unable to update contact information on high value transaction</li>
 *     <li>15 - Email already set on invoice</li>
 *     <li>16 - Unable to perform action outside of demo environment</li>
 *     <li>17 - Invalid invoice state</li>
 *     <li>18 - Misconfigured account</li>
 * </ul>
 * <pre>
 * eg 030101
 * </pre>
 *
 * @see <a href="https://bitpay.readme.io/reference/error-codes">Rest API Error Codes</a>
 */
public class InvoiceUpdateException extends InvoiceException {
    /**
     * Construct the InvoiceUpdateException.
     *
     * @param status String [optional] The Exception code to throw.
     * @param message String [optional] The Exception message to throw.
     */
    public InvoiceUpdateException(
        String status,
        String message
    ) {
        super(status, buildMessage(message));
    }

    private static String buildMessage(String message) {
        String bitPayMessage = "Failed to update invoice";
        String bitPayCode = "BITPAY-INVOICE-UPDATE";

        message = bitPayCode + ": " + bitPayMessage + " -> " + message;

        return message;
    }
}
