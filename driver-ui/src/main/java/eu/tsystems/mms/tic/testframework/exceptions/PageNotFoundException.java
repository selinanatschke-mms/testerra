/*
 * (C) Copyright T-Systems Multimedia Solutions GmbH 2018, ..
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 * Contributors:
 *     Peter Lehmann <p.lehmann@t-systems.com>
 *     pele <p.lehmann@t-systems.com>
 */
/*
 * Created on 14.08.2012
 *
 * Copyright(c) 2012 - 2012 T-Systems Multimedia Solutions GmbH
 * Riesaer Str. 5, 01129 Dresden
 * All rights reserved.
 */
package eu.tsystems.mms.tic.testframework.exceptions;

/**
 * Exception indicating that a page was not found.
 * 
 * @author pele
 */
public class PageNotFoundException extends RuntimeException {

    /**
     * Default serial UID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Create Exception with a message.
     * 
     * @param message Message for Exception.
     */
    public PageNotFoundException(final String message) {
        super(message);
    }

    /**
     * Exception create by the throwable and a message.
     * 
     * @param message Message for Exception.
     * @param cause Throwable that causes the exception.
     */
    public PageNotFoundException(final String message, final Throwable cause) {
        super(message, cause);
    }

    /**
     * Create Exception by a cause.
     * 
     * @param cause Throwable that causes the exception.
     */
    public PageNotFoundException(final Throwable cause) {
        super(cause);
    }
}