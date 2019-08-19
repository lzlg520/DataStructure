package com.lzlg.interview.xml;

public class DTDInfo {
    /**
     * DTD是规范XML文档结构的文档，起到了规范XML中数据结构的作用
     *
     * 定义规范如下：
     * 1.文档类型的定义：定义允许什么或不允许什么在文档中出现。
     *   预先规定文档中元素的结构，属性类型和实体引用等。
     *   可直接在文档中定义DTD或引用外部DTD。DTD不一定是必需的，
     *   只是需要的时候可以定义DTD。
     *
     * 2.DTD的调用：合法的XML文档必须遵循某一类wen文档的结构声明。
     *   一旦声明就会与此类文档相应结构关联起来。DTD的调用就是指
     *   定文档使用什么样的DTD，它出现在文档的XML声明后，基本元素之前，
     *   DTD可以包含在XML文档中，也可在外部定义，然后在XML文档中直接引用。
     *
     *
     *   属性表的声明语法：
     *   <!ATTLIST 对应的元素名 属性名 属性取值类型 属性默认值>
     *       对应的DTD文档中：
     *   <!ELEMENT 月薪 (#PCDATA)>
     *   <!ATTLIST 月薪 货币单位 CDATA"人民币">
     *
     *   属性的取值类型：
     *   1.CDATA：可以解析的字符数据
     *   2.Enumerated：枚举型，取值必须从中选出
     *   3.ENTITY：在DTD中声明的实体
     *   4.ENTITIES：在DTD中声明的若干实体
     *   5.ID：取值在文档中必须是唯一的
     *   6.IDREF：文档中某个元素的ID属性值
     *   7.NMTOKEN：任意不含空格的XML名称
     *   8.NMTOKENS：由空格分开的多个XML名称
     *   9.NOTATION：在DTD中声明的记号名
     *
     *   默认声明：
     *   #REQUIRED：说明必须为元素提供该属性。
     *   #IMPLIED：说明元素可以包含该属性，也可以不包含该属性。
     *   #FIXED + 默认值：说明一个固定的属性默认值，文档的编写者不能修改该属性的值。
     *   默认值：同上一种几乎差不多，只不过该属性值可以改变。
     */
}