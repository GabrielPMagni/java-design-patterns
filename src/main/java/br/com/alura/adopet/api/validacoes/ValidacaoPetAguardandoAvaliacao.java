package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoPetAguardandoAvaliacao implements ValidacaoSolicitacaoAdocao {
    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        boolean petAguardandoAvaliacao = petRepository.existsByPetIdAndStatus(dto.idPet(), StatusAdocao.AGUARDANDO_AVALIACAO);
        if (petAguardandoAvaliacao) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }
}
