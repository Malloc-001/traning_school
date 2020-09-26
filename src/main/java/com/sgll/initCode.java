package com.sgll;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;

public class initCode {
    public static void main(String[] args) {
//        需要一个 代码生成器 对象
        AutoGenerator mpg = new AutoGenerator();
        
//        配置策略

//        1、全局配置
        GlobalConfig gc = new GlobalConfig();
        String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath+"/src/main/java");
        gc.setAuthor("Malloc");
        gc.setOpen(false);//是否生成完成时打开资源管理器
        gc.setFileOverride(false);//是否覆盖原来的文件
        gc.setServiceName("%sService");//去掉service的I前缀
        gc.setIdType(IdType.AUTO);//设置主键类型
        gc.setDateType(DateType.ONLY_DATE);//设置时间类型
        gc.setSwagger2(true);

        mpg.setGlobalConfig(gc);

//        2、设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/db_training_sch?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT%2B8")
                .setUsername("root")
                .setPassword("root")
                .setDriverName("com.mysql.cj.jdbc.Driver")
                .setDbType(DbType.MYSQL);
        mpg.setDataSource(dataSourceConfig);
//        3、包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig
                .setModuleName("blog")
                .setParent("com.sgll")
                .setEntity("entity")
                .setMapper("mapper")
                .setService("service")
                .setController("controller");

        mpg.setPackageInfo(packageConfig);
//        4、策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("orders");     //输入要生成数据库中对应的表的表名
        strategy.setNaming(NamingStrategy.underline_to_camel);      //
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);    //
        strategy.setEntityLombokModel(true);//自动Lombok

        strategy.setLogicDeleteFieldName("deleted");

//        自动填充配置
        TableFill createTime = new TableFill("create_time", FieldFill.INSERT);
        TableFill updateTime = new TableFill("update_time", FieldFill.INSERT_UPDATE);
        ArrayList<TableFill> tableFills = new ArrayList<>();
        tableFills.add(createTime);
        tableFills.add(updateTime);
        strategy.setTableFillList(tableFills);

//        乐观锁   不是主流的锁
//        strategy.setVersionFieldName("version");
        strategy.setRestControllerStyle(true);//RestFull
        strategy.setControllerMappingHyphenStyle(true); //localhost:8080/hello_id_2 下划线命名

        mpg.setStrategy(strategy);

        //
        mpg.execute();//执行
    }
}