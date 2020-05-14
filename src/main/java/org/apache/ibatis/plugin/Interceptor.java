/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.plugin;

import java.util.Properties;

/**
 * @author Clinton Begin
 */
/**
 * 拦截器
 *
 */
public interface Interceptor {

  //拦截方法调用
  //四大对象运行方法时调用。
  //这个方法需要在plugin()方法创建代理对象时被显示调用才会在运行时被执行
  Object intercept(Invocation invocation) throws Throwable;

  //包装目标对象。包装：位目标对象创建一个代理对象。四大对象的代理对象.
  //代理对象的invoke方法体中要调用拦截器的intercept方法，这样intercept中的逻辑就会在代理对象执行方法时被执行
  //eg: Plugin.wrap(),使用方法见这个方法

  //四大对象创建时调用
  Object plugin(Object target);

  //设置属性，即配置文件中Plugin标签中定义的属性
  void setProperties(Properties properties);

}
