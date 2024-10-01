package br.com.alura.adopet.api.validacoes;

import org.springframework.beans.factory.annotation.Autowired;

import br.com.alura.adopet.api.dto.SolicitacaoAdocaoDto;
import br.com.alura.adopet.api.model.Adocao;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.PetRepository;
import br.com.alura.adopet.exception.ValidacaoException;

public class ValidacaoPetAguardandoAvaliacao implements ValidacaoSolicitacaoAdocao {
    @Autowired
    private PetRepository petRepository;

    public void validar(SolicitacaoAdocaoDto dto) {
        Adocao adocaoPet = petRepository.findById(dto.idPet()).get().getAdocao();

        if (adocaoPet.getStatus() == StatusAdocao.AGUARDANDO_AVALIACAO) {
            throw new ValidacaoException("Pet já está aguardando avaliação para ser adotado!");
        }
    }
}
