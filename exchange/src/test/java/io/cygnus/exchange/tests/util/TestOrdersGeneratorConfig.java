/*
 * Copyright 2020 Maksim Zheravin
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
package io.cygnus.exchange.tests.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.BitSet;
import java.util.List;
import java.util.function.Function;

import io.cygnus.exchange.core.common.CoreSymbolSpecification;

@AllArgsConstructor
@Builder
@Getter
public class TestOrdersGeneratorConfig {

	private final List<CoreSymbolSpecification> coreSymbolSpecifications;
	private final int totalTransactionsNumber;
	private final List<BitSet> usersAccounts;
	private final int targetOrderBookOrdersTotal;
	private final int seed;
	private final boolean avalancheIOC;
	private final PreFillMode preFillMode;

	@AllArgsConstructor
	public enum PreFillMode {

		ORDERS_NUMBER(TestOrdersGeneratorConfig::getTargetOrderBookOrdersTotal),
		ORDERS_NUMBER_PLUS_QUARTER(config -> config.targetOrderBookOrdersTotal * 5 / 4); // used for snapshot tests to
																							// let some margin positions
																							// open

		final Function<TestOrdersGeneratorConfig, Integer> calculateReadySeqFunc;
	}
}
