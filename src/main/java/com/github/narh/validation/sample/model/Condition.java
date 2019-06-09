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

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author narita
 *
 */
public class Condition implements Serializable {

  public enum DailyOrMonthly {
    DAILY, MONTHLY;
  }

  /** 種別 */
  private DailyOrMonthly dailyOrMonthly;

  /** 実行基準日時 */
  private String executeDayAndTime;

  /** 抽出開始日 */
  private int fromDay;

  /** 抽出開始時間 */
  private String fromTime;

  /** 抽出終了日 */
  private int toDay;

  /** 抽出終了時間 */
  private String toTime;

  /**
   * @return dailyOrMonthly
   */
  @XmlElement(name = "dailyOrMonthly")
  public DailyOrMonthly getDailyOrMonthly() {
    return dailyOrMonthly;
  }

  /**
   * @param dailyOrMonthly セットする dailyOrMonthly
   */
  public void setDailyOrMonthly(DailyOrMonthly dailyOrMonthly) {
    this.dailyOrMonthly = dailyOrMonthly;
  }

  /**
   * @return fromDay
   */
  @XmlElement(name = "FromDay")
  public int getFromDay() {
    return fromDay;
  }

  /**
   * @param fromDay セットする fromDay
   */
  public void setFromDay(int fromDay) {
    this.fromDay = fromDay;
  }

  /**
   * @return referenceDay
   */
  @XmlAttribute(name = "executeDayAndTime")
  public String getExecuteDayAndTime() {
    return executeDayAndTime;
  }

  /**
   * @param referenceDay セットする referenceDay
   */
  public void setExecuteDayAndTime(String executeDayAndTime) {
    this.executeDayAndTime = executeDayAndTime;
  }

  /**
   * @return fromTime
   */
  @XmlElement(name = "FromTime")
  public String getFromTime() {
    return fromTime;
  }

  /**
   * @param fromTime セットする fromTime
   */
  public void setFromTime(String fromTime) {
    this.fromTime = fromTime;
  }

  /**
   * @return toDay
   */
  @XmlElement(name = "ToDay")
  public int getToDay() {
    return toDay;
  }

  /**
   * @param toDay セットする toDay
   */
  public void setToDay(int toDay) {
    this.toDay = toDay;
  }

  /**
   * @return toTime
   */
  @XmlElement(name = "ToTime")
  public String getToTime() {
    return toTime;
  }

  /**
   * @param toTime セットする toTime
   */
  public void setToTime(String toTime) {
    this.toTime = toTime;
  }
}
