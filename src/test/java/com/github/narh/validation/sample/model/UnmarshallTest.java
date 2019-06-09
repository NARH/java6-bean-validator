/*
 * Copyright (c) 2019, NARH https://github.com/NARH
 * All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright notice,
 *   this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright notice,
 *   this list of conditions and the following disclaimer in the documentation
 *   and/or other materials provided with the distribution.
 * * Neither the name of the copyright holder nor the names of its contributors
 *   may be used to endorse or promote products derived from this software
 *   without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL <COPYRIGHT HOLDER> BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */

package com.github.narh.validation.sample.model;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

import java.io.StringReader;

import javax.xml.bind.JAXB;

import org.junit.Test;

/**
 * @author narita
 *
 */
public class UnmarshallTest {

  @Test
  public void unmarshallTest() throws Exception {
    StringBuilder stb = new StringBuilder();
    stb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
    stb.append("<root version=\"0.0.1\">");
    stb.append("<Conditions>");
    stb.append("<Condition executeDayAndTime=\"18:00\" dailyOrMonthly=\"DAILY\">");
    stb.append("  <FromTime>18:00</FromTime>");
    stb.append("  <ToTime>23:59</ToTime>");
    stb.append("</Condition>");
    stb.append("<Condition executeDayAndTime=\"00:00\" dailyOrMonthly=\"DAILY\">");
    stb.append("  <FromTime>00:00</FromTime>");
    stb.append("  <ToTime>05:59</ToTime>");
    stb.append("</Condition>");
    stb.append("<Condition executeDayAndTime=\"06:00\" dailyOrMonthly=\"DAILY\">");
    stb.append("  <FromTime>06:00</FromTime>");
    stb.append("  <ToTime>11:59</ToTime>");
    stb.append("</Condition>");
    stb.append("<Condition executeDayAndTime=\"12:00\" dailyOrMonthly=\"DAILY\">");
    stb.append("  <FromTime>12:00</FromTime>");
    stb.append("  <ToTime>17:59</ToTime>");
    stb.append("</Condition>");
    stb.append("</Conditions>");
    stb.append("</root>");

    RootModel dailyModel = JAXB.unmarshal(new StringReader(stb.toString()), RootModel.class);
    assertThat("version は 0.0.1 であること", dailyModel.getVersion(), is("0.0.1"));
    assertThat("Conditon 4件あること", dailyModel.getConditions().size(), is(4));
    assertThat("1件目の実行時間は 18:00 であること", dailyModel.getConditions().get(0).getExecuteDayAndTime(), is("18:00"));
    assertThat("1件目の開始時間は 18:00 であること", dailyModel.getConditions().get(0).getFromTime(), is("18:00"));
    assertThat("1件目の終了時間は 23:59 であること", dailyModel.getConditions().get(0).getToTime(), is("23:59"));

    assertThat("2件目の実行時間は 00:00 であること", dailyModel.getConditions().get(1).getExecuteDayAndTime(), is("00:00"));
    assertThat("2件目の開始時間は 00:00 であること", dailyModel.getConditions().get(1).getFromTime(), is("00:00"));
    assertThat("2件目の終了時間は 05:59 であること", dailyModel.getConditions().get(1).getToTime(), is("05:59"));

    assertThat("3件目の実行時間は 06:00 であること", dailyModel.getConditions().get(2).getExecuteDayAndTime(), is("06:00"));
    assertThat("3件目の開始時間は 06:00 であること", dailyModel.getConditions().get(2).getFromTime(), is("06:00"));
    assertThat("3件目の終了時間は 11:59 であること", dailyModel.getConditions().get(2).getToTime(), is("11:59"));

    assertThat("4件目の実行時間は 12:00 であること", dailyModel.getConditions().get(3).getExecuteDayAndTime(), is("12:00"));
    assertThat("4件目の開始時間は 12:00 であること", dailyModel.getConditions().get(3).getFromTime(), is("12:00"));
    assertThat("4件目の終了時間は 17:59 であること", dailyModel.getConditions().get(3).getToTime(), is("17:59"));
  }
}
