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

import java.util.Date;
import java.util.List;

import com.github.narh.validation.sample.model.Condition;
import com.github.narh.validation.sample.model.RootModel;

/**
 * @author narita
 *
 */
public class ConditionChecker {

  /** 試験予定日 */
  private final Date executeDate;
  /** 試験対象のモデル */
  private final RootModel rootModel;

  /**
   * コンストラクタ
   * @param rootModel
   * @param executeDate
   */
  public ConditionChecker(final RootModel rootModel, final Date executeDate) {
    this.rootModel = rootModel;
    this.executeDate = executeDate;
  }

  /**
   * @return executeDate
   */
  public Date getExecuteDate() {
    return executeDate;
  }


  /**
   * @return rootModel
   */
  public RootModel getRootModel() {
    return rootModel;
  }


  /**
   * 期間を取得する
   * @return
   */
  public List<Condition> getConditions() {
    return rootModel.getConditions();
  }

  private boolean isDaily() {
    return false;
  }

  private boolean isMonthly() {
    return false;
  }

  /**
   * チェックハンドラを取得する
   * @return
   */
  public CheckHandler getCheckHandler() throws IllegalArgumentException {
    if(isDaily() && isMonthly())
      throw new IllegalArgumentException("日時と月次が混在しています");
    else if(isDaily())
      return new DailyCheckHandler(this);
    else if(isMonthly())
      return new MonthlyCheckhandler(this);
    else
      throw new IllegalArgumentException("抽出期間が未設定です");
  }
}
