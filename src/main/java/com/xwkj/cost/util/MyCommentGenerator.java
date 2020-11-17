package com.xwkj.cost.util;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.internal.DefaultCommentGenerator;

/**
 * 自动生成类之一
 * 修改实体类注释
 * 需要在generatorConfig.xml配置文件中配置
 * @author 张永辉
 */
public class MyCommentGenerator extends DefaultCommentGenerator {

    public MyCommentGenerator() {
    }


    @Override
    public void addFieldComment(Field field,IntrospectedTable introspectedTable,IntrospectedColumn introspectedColumn) {
        if (introspectedColumn.getRemarks() != null && !introspectedColumn.getRemarks().equals("")) {
            field.addJavaDocLine("/**");
            field.addJavaDocLine(" * " + "对应字段：" + introspectedColumn.getActualColumnName() + "，  字段含义：" + introspectedColumn.getRemarks().replaceAll("\\s"," "));
            field.addJavaDocLine(" */");
        }
    }
}
