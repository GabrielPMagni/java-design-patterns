package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoTutorEmAndamento implements ValidacaoSolicitacaoAdocao {

    @Autowired
    private TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean tutorEmAndamento = tutorRepository.existsByTutorIdAndAdocaoStatus(dto.idTutor(), StatusAdocao.AGUARDANDO_AVALIACAO);
        if (tutorEmAndamento) {
            throw new ValidacaoException("Tutor já possui outra adoção aguardando avaliação!");
        }
    }
}
