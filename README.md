# Spring IOC 基于 工厂模式

  - ## IOC 的  bean 管理
	- 步骤 (创建、注入属性)
	- 操作(注入)方式 (xml配置文件、注解注入)
  - ## xml操作
     - ### 创建
		在xml配置文件 添加 <bean id="name" class="allClassPath"> 标签
			属性     id:名称/键  class:类的全路径   name(比较少用)
		默认调用无参构造方法
     - ### 注入属性(基本类型)
        - **ID依赖注入**
			1. set方法注入	
				<!-- set方法注入属性 -->
			    <bean id="setInitUser" class="com.cym.model.User" p:gender="female">
			        <!-- p:属性名="属性值"   成为p名称空间注入  注意要加入 xmlns:p="http://www.springframework.org/schema/p"  -->
			        <!-- name为属性名 value为属性值 -->
			        <property name="age" value="20"></property>
			        <property name="name" value="set"></property>
			    </bean>
			2. 有参构造
				<!-- 构造方法注入属性  注意:参数要写全 -->
			    <bean id="constructorInitUser" class="com.cym.model.User">
			        <!-- name为属性名 value为属性值  -->
			        <constructor-arg name="age" value="10"></constructor-arg>
			        <constructor-arg name="gender">
			        	<!-- 属性/参数赋值 可以嵌套 value标签 -->
			            <!-- 特殊字符处理 1) &lt;&gt;  2)<![CDATA[xxx]]>  -->
            			<value><![CDATA[<>男<>]]></value>
			        </constructor-arg>
			        <!-- index 参数列表下标的 -->
			        <constructor-arg index="0" value="constructor"></constructor-arg>
			    </bean>

      - **注入集合/自定义对象**
	    1. 嵌套bean / 内部bean
			<!-- 构造方法注入属性  注意:参数要写全 -->
		    <bean id="constructorInitPhone" class="com.cym.model.Phone">
		        <constructor-arg name="size" value="10"></constructor-arg>
		        <constructor-arg name="productionPlace" value="China"></constructor-arg>
		        <constructor-arg index="0" value="iphone"></constructor-arg>
		        <property name="user">
		            <bean class="com.cym.model.User">
				        <constructor-arg name="age" value="10"></constructor-arg>
				        <constructor-arg name="gender" value="男"></constructor-arg>
				        <constructor-arg index="0" value="meee"></constructor-arg>
				    </bean>
		        </property>
		    </bean>

	    2. 外部bean
		    <!-- set方法注入属性   外部bean/级联赋值1   -->
		    <bean id="setInitPhone" class="com.cym.model.Phone">
		        <property name="user" ref="setInitUser">
		        </property>
		    </bean>

		3. 级联
		<!-- 构造方法注入属性  级联赋值2 -->
	    <bean id="constructorInitPhone1" class="com.cym.model.Phone">
	        <!-- name为属性名 value为属性值  -->
	        <constructor-arg name="size" value="10"></constructor-arg>
	        <constructor-arg name="productionPlace" value="China"></constructor-arg>
	        <!-- index 参数列表下标的 -->
	        <constructor-arg index="0" value="iphone"></constructor-arg>
	        <property name="user" ref="user"></property>
	        <!-- 需要有getUser() 方法 -->
	        <property name="user.name" value="级联赋值2"></property>
	    </bean>

		4. 集合注入
			<!-- set方法注入属性  集合    -->
		    <bean id="setInitStu" class="com.cym.model.Student">
		        <property name="cources">
		            <map>
		                <entry key="aa" value="11"></entry>
		            </map>
		        </property>
		        <property name="grand">
		            <list>
		                <value>111</value>
		                <value>222</value>
		            </list>
		        </property>
		        <!-- 
		        <property name="arr">
		            <array>
		                <value>111</value>
		                <value>222</value>
		            </array>
		        </property>
		        <property name="set">
		            <set>
		                <value>111</value>
		                <value>222</value>
		            </set>
		        </property>
		         -->
		    </bean>
      - ### 对象注入:
		    1. <bean id="course1" class="com.cym.model.Course">
		        <constructor-arg name="cName" value="Chinese"></constructor-arg>
		        <constructor-arg name="tName" value="Chinese teacher name"></constructor-arg>
			    </bean>
			    <bean id="course2" class="com.cym.model.Course">
			        <constructor-arg name="cName" value="Math"></constructor-arg>
			        <constructor-arg name="tName" value="Math teacher name"></constructor-arg>
			    </bean>
			    <bean id="course3" class="com.cym.model.Course">
			        <constructor-arg name="cName" value="English"></constructor-arg>
			        <constructor-arg name="tName" value="English teacher name"></constructor-arg>
			    </bean>
			    <!-- set方法对象注入集合      -->
			    <bean id="setInitStu" class="com.cym.model.Student">
			        <property name="cources">
			            <map>
			                <entry key="chinese">
			                    <ref bean="course1"/>
			                </entry>
			                <entry key="math">
			                    <ref bean="course2"/>
			                </entry>
			                <entry key="english">
			                    <ref bean="course3"/>
			                </entry>
			            </map>
			        </property>
			        <property name="report">
			            <list>
			                <value>111</value>
			                <value>222</value>
			                <value>333</value>
			            </list>
			        </property>
			    </bean>

		    2.	<!-- 获取集合类型属性的注入 -->
			    <!-- 更改配置文件頭 
			    xmlns:util="http://www.springframework.org/schema/util"
			    xsi:schemaLocation="...
			    +   http://www.springframework.org/schema/util
			    +   http://www.springframework.org/schema/util/spring-util.xsd"
			     -->
			    <util:map id="courseMap">
					<entry key="chinese">
			        	<ref bean="course1"/>
			        </entry>
			        <entry key="math">
			        	<ref bean="course2"/>
			        </entry>
			        <entry key="english">
			        	<ref bean="course3"/>
			        </entry>
			    </util:map>
			    <util:list id="reportList">
			        <value>100</value>
			        <value>30</value>
			        <value>50</value>
			    </util:list>
			    <!-- set方法注入外部集合      -->
			    <bean id="setInitStu2" class="com.cym.model.Student">
			        <property name="cources" ref="courseMap">
			        </property>
			        <property name="report" ref="reportList">
			        </property>
			    </bean>
		<!-- 获取集合类型属性的注入 -->
	    <!-- 更改配置文件頭 
	    xmlns:util="http://www.springframework.org/schema/util"
	    xsi:schemaLocation="...
	    +   http://www.springframework.org/schema/util
	    +   http://www.springframework.org/schema/util/spring-util.xsd"
	     -->
	    <util:map id="courseMap">
			<entry key="chinese">
	        	<ref bean="course1"/>
	        </entry>
	        <entry key="math">
	        	<ref bean="course2"/>
	        </entry>
	        <entry key="english">
	        	<ref bean="course3"/>
	        </entry>
	    </util:map>
	    <util:list id="reportList">
	        <value>100</value>
	        <value>30</value>
	        <value>50</value>
	    </util:list>
	    <!-- set方法注入外部集合      -->
	    <bean id="setInitStu2" class="com.cym.model.Student">
	        <property name="cources" ref="courseMap">
	        </property>
	        <property name="report" ref="reportList">
	        </property>
	    </bean>

## XML自动装配
	 	<!-- 自动装配对象 
    	autowire="byName" 根据属性名称为id寻找对应的bean,找不到则设为null 
	    autowire="byType" 根据属性类型为依据,寻找对应的bean,但该类型有唯一<bean />,否则报错:No qualifying bean of type 'com.cym.model.User' available: expected single matching bean but found 2: user1,user
	    -->
	    <bean id="phone" class="com.cym.model.Phone" autowire="byName">
	    </bean>
	    <bean id="user1" class="com.cym.model.User" p:gender="female">
	        <property name="age" value="20"></property>
	        <property name="name" value="set"></property>
	    </bean>
	    <bean id="user" class="com.cym.model.User" p:gender="male">
	        <property name="age" value="22"></property>
	        <property name="name" value="set"></property>
	    </bean>

## 引入外部文件
    <!-- 引入外部属性文件 注入bean属性 -->
	<!-- 添加头部信息
	xmlns:context="http://www.springframework.org/schema/context"
	 xsi:schemaLocation="...
	 +++	http://www.springframework.org/schema/context
     +++	http://www.springframework.org/schema/context/spring-context.xsd"
	 -->
    <context:property-placeholder local-override="classpath:jdbc.properties"/>
    <bean id="dataDruid2" class="com.alibaba.druid.pool.DruidDataSource">
        <property name="driverClassName" value="${prop.driverClass}"></property>
        <property name="url" value="${prop.url}"></property>
        <property name="username" value="${prop.userName}"></property>
        <property name="password" value="${prop.pwd}"></property>
    </bean>

##注解方式注入
 - **格式**:
    - @注解(属性名=值,属性名=值,...)各注解实现基本相同,不同注解只是为了方便开发
       - 1. @Component:普通注解，注入普通类对象
       - 2. @Service:业务处理层注解,一般用在业务逻辑层的类中
       - 3. @Controller:控制层注解,一般用在 web 控制层
       - 4. @Repository:永久层注解,一般用在 dao 层/ po类
       - .....
    - 依赖: 添加 aop 包  
       - 设置XML  (转)-->  引入外部文件
       - 开启扫描包路径