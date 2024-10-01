package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoTutorMaximoAdocoes implements ValidacaoSolicitacaoAdocao {
    private final int limiteAdocoes = 5;

    @Autowired
    TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean tutorMaxAdocoes = tutorRepository.hasMaxAdocoes(dto.idTutor(), limiteAdocoes);

        if (tutorMaxAdocoes) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de " + this.limiteAdocoes + " adoções!");
        }
    }
}
