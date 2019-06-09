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

package com.github.narh.validation.sample;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

/**
 * @author narita
 *
 */
public class MonthlyCheckhandler extends AbstractCheckHandler {

  SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
  Locale defaultLocale = Locale.JAPANESE;

  private List<Calendar> checkMonthlyList = null;

  private String[] checkMonthlies = {
       "2019-02-01","2019-03-01","2019-04-01","2019-05-01","2019-06-01"
      ,"2020-02-01","2020-03-01","2020-04-01","2020-05-01"
  };

  /**
   * @param conditionChecker
   */
  public MonthlyCheckhandler(final ConditionChecker conditionChecker) {
    super(conditionChecker);
  }

  private List<Calendar> getCheckMonthlies() {
    if(null == checkMonthlyList) {
      for(String month:checkMonthlies) {
        Calendar calendar = Calendar.getInstance(defaultLocale);
        try {
          calendar.setTime(simpleDateFormat.parse(month));
        } catch (ParseException e) {
          throw new RuntimeException(e);
        }
      }
    }
    return checkMonthlyList;
  }
}
