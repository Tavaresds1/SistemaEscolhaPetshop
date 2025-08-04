import React, { useState } from 'react';
import { Calendar, Dog, ArrowRight } from 'lucide-react';
import './App.css'; // Importa o arquivo CSS para estilização

const App = () => {
  // O estado 'data' armazena a string da data.
  const [data, setData] = useState('');
  const [pequenos, setPequenos] = useState('');
  const [grandes, setGrandes] = useState('');
  const [resposta, setResposta] = useState(null);
  const [erro, setErro] = useState('');

  const buscarMelhorPetshop = async () => {
    // Limpa os estados de erro e resposta antes de cada nova busca.
    setErro('');
    setResposta(null);

    // Validação básica no frontend para prevenir requisições vazias.
    if (!data || pequenos === '' || grandes === '') {
        setErro('Preencha todos os campos para continuar.');
        return;
    }

    try {
        const response = await fetch('http://localhost:8080/api/petshop', {
            method: 'POST',
            headers: { 'Content-Type': 'application/json' },
            body: JSON.stringify({
                data,
                qtdPequenos: Number(pequenos),
                qtdGrandes: Number(grandes)
            })
        });

        if (!response.ok) {
            // Verifica o cabeçalho Content-Type para saber se a resposta é JSON.
            const contentType = response.headers.get('Content-Type');
            let errorMessages = 'Ocorreu um erro desconhecido.';
            
            if (contentType && contentType.includes('application/json')) {
                // Se for JSON, processa a resposta como JSON.
                const errorData = await response.json();
                
                // Formata as mensagens de erro do mapa de validação do backend.
                if (Object.keys(errorData).length > 0) {
                    errorMessages = Object.values(errorData).join('\n');
                } else {
                    errorMessages = errorData.message || errorMessages;
                }
            } else {
                // Se não for JSON, lê a resposta como texto simples.
                const errorText = await response.text();
                errorMessages = `Erro do Servidor:\n${errorText}`;
            }

            throw new Error(errorMessages);
        }

        const dataResp = await response.json();
        setResposta(dataResp);

    } catch (err) {
        console.error('Erro completo:', err);
        // Exibe a mensagem de erro na interface do usuário.
        setErro(err.message || 'Ocorreu um erro desconhecido.');
    }
  };

  return (
    <div className="app-container">
      <div className="petshop-card">
        <h1 className="title">Melhor Petshop</h1>

        {/* Formulário de entrada de dados */}
        <div className="form-group-container">
          <div className="form-group">
            <Calendar className="icon" size={24} />
            <input
              type="text"
              value={data}
              onChange={e => setData(e.target.value)}
              placeholder="Data (dd/MM/yyyy)"
              className="input-field"
            />
          </div>

          <div className="form-group">
            <Dog className="icon" size={24} />
            <input
              type="number"
              value={pequenos}
              onChange={e => setPequenos(e.target.value)}
              placeholder="Cães Pequenos"
              className="input-field"
            />
          </div>

          <div className="form-group">
            <Dog className="icon" size={24} />
            <input
              type="number"
              value={grandes}
              onChange={e => setGrandes(e.target.value)}
              placeholder="Cães Grandes"
              className="input-field"
            />
          </div>
        </div>

        {/* Botão para buscar o melhor petshop */}
        <button
          onClick={buscarMelhorPetshop}
          className="submit-button"
        >
          <span>Buscar Melhor Petshop</span>
          <ArrowRight className="icon-right" size={24} />
        </button>

        {/* Exibição de erros e resultados */}
        {erro && (
          <div className="alert-error" role="alert">
            <p className="alert-title">Erro de Validação:</p>
            <p className="alert-message">{erro}</p>
          </div>
        )}

        {resposta && (
          <div className="alert-success">
            <h2 className="result-title">Resultado</h2>
            <p className="result-text">
              O melhor petshop é <strong className="result-strong">{resposta.nome}</strong>, com um preço total de <strong className="result-strong">R$ {resposta.preco.toFixed(2).replace('.', ',')}</strong>.
            </p>
          </div>
        )}
      </div>
    </div>
  );
};

export default App;
