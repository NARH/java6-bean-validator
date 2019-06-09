package com.github.narh.validation.sample.model;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.bval.jsr.ApacheValidationProvider;
import org.junit.Before;
import org.junit.Test;

/*
 * Copyright (c) 2018, NARH https://github.com/NARH
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

/**
 * @author narita
 *
 */
public class SimpleValidation {

  private ValidatorFactory vf = Validation
      .byProvider(ApacheValidationProvider.class)
      .configure()
      .buildValidatorFactory();

  private Validator validator;

  @Before
  public void setUp() throws Exception {
    validator = vf.getValidator();
  }

  @Test
  public void requiredTest() throws Exception {
    SampleModel model =  new SampleModel();
    Set<ConstraintViolation<SampleModel>> results = validator.validate(model);
    for(ConstraintViolation<SampleModel> result:results)
      System.out.println(result.getMessage());
  }


  public class SampleModel {
    @NotNull
    private String name;
    @NotNull @Min(0)
    private int age;
    /**
     * @return name
     */
    public String getName() {
      return name;
    }
    /**
     * @param name セットする name
     */
    public void setName(String name) {
      this.name = name;
    }
    /**
     * @return age
     */
    public int getAge() {
      return age;
    }
    /**
     * @param age セットする age
     */
    public void setAge(int age) {
      this.age = age;
    }

  }
}
