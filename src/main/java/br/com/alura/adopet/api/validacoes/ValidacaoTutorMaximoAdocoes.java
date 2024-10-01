package br.com.alura.adopet.api.validacoes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.TutorRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoTutorMaximoAdocoes implements ValidacaoSolicitacaoAdocao {
    private final int limiteAdocoes = 5;

    @Autowired
    TutorRepository tutorRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        List<Adocao> adocoesTutor = tutorRepository.findById(dto.idTutor()).get().getAdocoes();

        if (adocoesTutor.stream().filter(a -> a.getStatus() == StatusAdocao.APROVADO).count() >= this.limiteAdocoes) {
            throw new ValidacaoException("Tutor chegou ao limite máximo de " + this.limiteAdocoes + " adoções!");
        }
    }
}
