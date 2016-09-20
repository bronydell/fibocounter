/**
 * Fibonacci numbers counter
 * 
 * @copyright Copyright (C) 2016 al3xable <al3xable@yandex.com>. All rights reserved.
 * @license https://opensource.org/licenses/GPL-3.0 GNU General Public License version 3
 * @version 1.0
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.al3xable.fibocounter;

import java.math.BigInteger;

public class Main {
	public static void main(String[] args) {
		BigInteger pre = new BigInteger("0");
		BigInteger cur = new BigInteger("1");
		BigInteger sum = new BigInteger("1");
		
		while (true) {
			System.out.println(sum);
			sum = pre.add(cur);
			pre = cur;
			cur = sum;
		}
	}
}