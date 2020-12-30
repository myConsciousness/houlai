/*
 * Copyright 2020 Kato Shinya.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package org.houlai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * ソース管理アプリケーション「鳳来」のエントリーポイントです。
 *
 * @author Kato Shinya
 * @since 1.0
 * @version 1.0
 */
@SpringBootApplication
public class HoulaiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HoulaiApplication.class, args);
	}
}
