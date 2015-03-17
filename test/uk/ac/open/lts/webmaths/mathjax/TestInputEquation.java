/*
This file is part of OU webmaths

OU webmaths is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

OU webmaths is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with OU webmaths. If not, see <http://www.gnu.org/licenses/>.

Copyright 2015 The Open University
*/
package uk.ac.open.lts.webmaths.mathjax;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Test;

public class TestInputEquation
{
	@Test
	public void testGetFromMathmlNotTex() throws IOException
	{
		String empty = "<math xmlns=\"http://www.w3.org/1998/Math/MathML\"></math>";
		InputEquation eq = InputEquation.getFromMathml(empty);
		assertTrue(eq instanceof InputMathmlEquation);
		assertEquals(empty, eq.getContent());
	}

	@Test
	public void testGetFromMathmlTex() throws IOException
	{
		InputEquation eq = InputEquation.getFromMathml(
			"<math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
			"<semantics><mi>x</mi><annotation encoding=\"application/x-tex\">\n" +
			"x\n</annotation></semantics>\n" +
			"</math>");
		assertTrue(eq instanceof InputTexInlineEquation);
		assertEquals("x", eq.getContent());
	}
}