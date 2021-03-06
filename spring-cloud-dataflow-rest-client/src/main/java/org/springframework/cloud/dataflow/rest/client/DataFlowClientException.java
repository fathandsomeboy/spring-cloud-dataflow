/*
 * Copyright 2013-2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.cloud.dataflow.rest.client;

import org.springframework.hateoas.VndErrors;

/**
 * A Java exception that wraps the serialized {@link VndErrors} object.
 *
 * @author Eric Bottard
 * @author Mark Fisher
 */
@SuppressWarnings("serial")
public class DataFlowClientException extends RuntimeException {

	private VndErrors vndErrors;

	public DataFlowClientException(VndErrors error) {
		this.vndErrors = error;
	}

	@Override
	public String getMessage() {
		StringBuilder builder = new StringBuilder();
		for (VndErrors.VndError e : vndErrors) {
			builder.append(e.getMessage()).append('\n');
		}
		return builder.toString();
	}
}
