package br.com.meta.mensageria.services;

import br.com.meta.dto.VisitorDTO;
import br.com.meta.mensageria.utils.EntitiesUtils;
import br.com.meta.services.ConsumeMessageService;
import br.com.meta.services.VisitorService;
import com.google.gson.Gson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
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
}
