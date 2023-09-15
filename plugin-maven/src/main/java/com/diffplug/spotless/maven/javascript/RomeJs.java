/*
 * Copyright 2016-2023 DiffPlug
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
package com.diffplug.spotless.maven.javascript;

import com.diffplug.spotless.maven.rome.AbstractRome;
import com.diffplug.spotless.rome.EBiomeFlavor;

/**
 * Rome formatter step for JavaScript.
 * @deprecated Rome has transitioned to Biome. This will be removed shortly.
 */
@Deprecated
public class RomeJs extends AbstractRome {
	public RomeJs() {
		super(EBiomeFlavor.ROME);
	}

	@Override
	protected String getLanguage() {
		return "js?";
	}
}
