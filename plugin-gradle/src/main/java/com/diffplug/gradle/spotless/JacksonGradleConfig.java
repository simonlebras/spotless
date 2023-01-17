/*
 * Copyright 2023 DiffPlug
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
 */
package com.diffplug.gradle.spotless;

import java.util.Collections;

import com.diffplug.spotless.FormatterStep;
import com.diffplug.spotless.json.JacksonConfig;
import com.diffplug.spotless.json.JacksonJsonStep;

public abstract class JacksonGradleConfig {
	protected final FormatExtension formatExtension;

	protected JacksonConfig jacksonConfig;

	protected String version = JacksonJsonStep.defaultVersion();

	public JacksonGradleConfig(JacksonConfig jacksonConfig, FormatExtension formatExtension) {
		this.formatExtension = formatExtension;

		this.jacksonConfig = jacksonConfig;
		formatExtension.addStep(createStep());
	}

	public JacksonGradleConfig(FormatExtension formatExtension) {
		this(new JacksonConfig(), formatExtension);
	}

	public JacksonGradleConfig config(JacksonConfig jacksonConfig) {
		this.jacksonConfig = jacksonConfig;
		formatExtension.replaceStep(createStep());
		return this;
	}

	public JacksonGradleConfig feature(String feature, boolean toggle) {
		this.jacksonConfig.appendFeatureToToggle(Collections.singletonMap(feature, toggle));
		formatExtension.replaceStep(createStep());
		return this;
	}

	public JacksonGradleConfig version(String version) {
		this.version = version;
		formatExtension.replaceStep(createStep());
		return this;
	}

	protected abstract FormatterStep createStep();
}
