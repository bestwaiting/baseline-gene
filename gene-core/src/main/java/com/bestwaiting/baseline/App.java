package com.bestwaiting.baseline;

import com.bestwaiting.baseline.model.dto.LocalGeneParamsDto;
import com.bestwaiting.baseline.service.GeneService;
import com.google.common.collect.Lists;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 */
public class App {
    /**
     * java -Dparams='{"structures":[],"host":"127.0.0.1","port":3306,"dbname":"gene","username":"root",
     * "password":"root","tableNames":[],"author":"baseline-gene","moduleType":"single","groupId":"com.baseline
     * .testl","artifactId":"baseline"}' -jar baseline-gene.jar
     *
     * @param args
     */
    public static void main(String[] args) {
        String paramStr = System.getProperty("params");
        System.out.println("params----" + paramStr);
        if (StringUtils.isBlank(paramStr)) {
            System.out.println("gene params is empty!");
            return;
        }
        System.out.println("Hello New World! Gene start ~");

        Gson gson = new GsonBuilder().create();
        LocalGeneParamsDto paramsDto = gson.fromJson(paramStr, LocalGeneParamsDto.class);

        GeneService geneService = new GeneService();
        geneService.geneCode4Local(paramsDto);

        System.out.println("Hello New World! Gene end ~");
    }

    private void test() {
        LocalGeneParamsDto paramsDto = new LocalGeneParamsDto();
        paramsDto.setHost("127.0.0.1");
        paramsDto.setPort(3306);
        paramsDto.setDbname("gene");
        paramsDto.setUsername("root");
        paramsDto.setPassword("root");
        paramsDto.setTableNames(Lists.newArrayList());
        paramsDto.setStructures(Lists.newArrayList());
        paramsDto.setModuleType("single");
        paramsDto.setGroupId("com.baseline.testl");
        paramsDto.setArtifactId("baseline");
    }
}