package br.com.meta.services;

import br.com.meta.dto.VisitorDTO;
import br.com.meta.utils.EntitiesUtils;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.lang.reflect.Type;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ConsumeMessageServiceTest {
    @InjectMocks
    private ConsumeMessageService consumeMessageService;

    @Mock
    private VisitorService service;

    @Test
    public void  consumeMessageSuccess(){

        Gson gson = mock(Gson.class);
        VisitorDTO vDTO = EntitiesUtils.criarDTO();

        when(service.save(Mockito.any())).thenReturn(vDTO);

        consumeMessageService.consumeMessage(EntitiesUtils.criarStr());

       assertThat(vDTO.getName()).isEqualTo((EntitiesUtils.criarDTO()).getName());
    }

    @Test
    public void  consumeMessageError(){
        Gson gson = mock(Gson.class);
        VisitorDTO vDTO = EntitiesUtils.criarDTO();

        consumeMessageService.consumeMessage(EntitiesUtils.criarStrNomeNull());

        assertThatIllegalArgumentException();
    }
}
