package com.github.charlotte.arica.service;

import com.github.charlotte.arica.dao.ItemDAO;
import com.github.charlotte.arica.entity.Item;
import com.github.charlotte.arica.entity.ItemExample;
import com.github.charlotte.arica.util.FreemarkerUtil;
import freemarker.template.Template;
import freemarker.template.TemplateException;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import java.io.*;
import java.util.*;

@Service
public class ItemService  {

	@Autowired
	ItemDAO itemDao;


	@Value(value = "${nginx.html.root}")
	String htmlRoot;

	public Item insert(Item item) {

		itemDao.insert(item);
		return item;
	}

	public Item findById(int id) {
		return itemDao.selectByPrimaryKey(id);
	}

	public List<Item> findAll() {
		ItemExample example = new ItemExample();
		return itemDao.selectByExample(example );
	}

	public void generateHtml(int id) throws IOException {

		// 从数据源，获取数据
		Item item = itemDao.selectByPrimaryKey(id);

		// 文件写入路径
		String fileName = "item"+id+".html";
		String filePath = htmlRoot;
		// 路径 直接能被用户访问
		Template template = FreemarkerUtil.getTemplate("templates/item.ftl");
		//加载数据
		Map<String, Object> dataModel  =new HashMap<>();

		dataModel.put("item", item);
		//创建输出对象,将文件输出到 tmp 目录下
		BufferedWriter fileWriter = new BufferedWriter(new FileWriter(filePath+fileName));
		//渲染模板和数据
		try {
			template.process(dataModel, fileWriter);
		} catch (TemplateException e) {
			e.printStackTrace();
		}
		//关闭输出
		fileWriter.close();
	}

	public String getFileTemplateString() throws Exception{
		// TODO Auto-generated method stub

		// tomcat 下部署项目，可以这么取
		// 获取 静态模板文件的输入流
		String file = ClassUtils.getDefaultClassLoader().getResource("templates/item.html").getFile();
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));


		// 读缓冲区
		StringBuffer sb = new StringBuffer();

		String lineStr = reader.readLine();
		while (lineStr!=null) {
			sb.append(lineStr).append("\r\n");
			lineStr = reader.readLine();
		}
		reader.close();

		return sb.toString();
	}

	public void saveFileTemplateString(String content)throws Exception {

		String file = ClassUtils.getDefaultClassLoader().getResource("templates/item.html").getFile();

		BufferedWriter writer = new BufferedWriter(new FileWriter(file));
		writer.write(content);
		writer.flush();
		writer.close();
	}


}
