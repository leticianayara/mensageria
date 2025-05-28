package br.com.meta.utils;

import br.com.meta.dto.VisitorDTO;
import br.com.meta.models.Visitor;

public class EntitiesUtils {

    public static Visitor criar(){
        return new Visitor("5f1fc4f5-17cf-4854-bbb5-e2872e3fc39a", "teste 1", "rfdsfmdfmsasd" );
    }

    public static VisitorDTO criarDTO(){
        VisitorDTO vDTO = new VisitorDTO();
        vDTO.setId("5f1fc4f5-17cf-4854-bbb5-e2872e3fc39a");
        vDTO.setName("teste 1");
        vDTO.setDescription("rfdsfmdfmsasd");
        return vDTO;
    }

    public static String criarStr(){
        return "{\n  \"id\": \"5f1fc4f5-17cf-4854-bbb5-e2872e3fc39a\",\n  \"name\": \"teste 1\",\n  \"description\": \"rfdsfmdfmsasd\"\n}";
    }

    public static String criarStrNomeNull(){
        return "{\n  \"id\": \"5f1fc4f5-17cf-4854-bbb5-e2872e3fc39a\",\n  \"name\": \"teste 1\",\n  \"description\": \"rfdsfmdfmsasd\"\n}";
    }
}
