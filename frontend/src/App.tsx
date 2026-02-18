import { useEffect, useState } from 'react'

interface RelatorioTotal {
  NOME?: string;
  VALOR_TOTAL_PEDIDOS?: number;
}

function App() {
  const [dados, setDados] = useState<RelatorioTotal[]>([]);
  const [loading, setLoading] = useState(true);

  const carregarDados = async () => {
    try {
      setLoading(true);
      const response = await fetch("http://localhost:8080/api/pedidos/relatorio-totais");
      const json = await response.json();
      setDados(json);
    } catch (error) {
      console.error(error);
    } finally {
      setLoading(false);
    }
  };

  useEffect(() => { carregarDados(); }, []);

  return (
    <div className="min-h-screen bg-slate-50 p-6 md:p-12 text-slate-800 font-sans">
      <div className="max-w-4xl mx-auto">

        <header className="mb-12 flex flex-col md:flex-row md:items-center justify-between gap-6">
          <div>
            <h1 className="text-4xl font-black text-slate-900 tracking-tight">Vendas por Cliente</h1>
            <p className="text-slate-500 mt-2 text-lg">Resumo financeiro atualizado</p>
          </div>
          <button
            onClick={carregarDados}
            className="bg-indigo-600 hover:bg-indigo-700 text-white font-bold py-4 px-8 rounded-2xl shadow-xl shadow-indigo-200 transition-all hover:-translate-y-1 active:scale-95"
          >
            Atualizar Dados
          </button>
        </header>

        <div className="grid gap-4">
          {loading ? (
            <div className="p-20 text-center bg-white rounded-3xl border-2 border-dashed border-slate-200 text-slate-400">
              Carregando informações do banco...
            </div>
          ) : dados.length > 0 ? (
            dados.map((item, i) => (
              <div key={i} className="bg-white rounded-3xl p-8 shadow-sm border border-slate-100 flex items-center justify-between group hover:border-indigo-200 transition-all">
                <div className="flex items-center gap-6">
                  <div className="h-14 w-14 bg-linear-to-br from-indigo-500 to-purple-600 text-white rounded-2xl flex items-center justify-center font-bold text-2xl shadow-lg shadow-indigo-100">
                    {item.NOME?.charAt(0)}
                  </div>
                  <div>
                    <h3 className="font-bold text-xl text-slate-900 group-hover:text-indigo-600 transition-colors">{item.NOME}</h3>
                    <p className="text-slate-400 text-sm font-semibold uppercase tracking-widest">Status: Ativo</p>
                  </div>
                </div>

                <div className="text-right">
                  <p className="text-xs text-slate-400 font-black uppercase mb-1">Total Gasto</p>
                  <p className="text-3xl font-black text-emerald-600">
                    R$ {Number(item.VALOR_TOTAL_PEDIDOS).toLocaleString('pt-BR', { minimumFractionDigits: 2 })}
                  </p>
                </div>
              </div>
            ))
          ) : (
            <div className="p-20 text-center bg-white rounded-3xl border-2 border-dashed border-slate-200 text-slate-400">
              Nenhum dado encontrado. Envie as requisições no Postman!
            </div>
          )}
        </div>
      </div>
    </div>
  );
}

export default App;