package br.com.alura.adopet.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoTutorEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
         List<Adocao> adocoesTutor = tutorRepository.findById(dto.idTutor()).get().getAdocoes();
        for (Adocao a : adocoesTutor) {
            if (a.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
                throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
            }
        }
    }
}
