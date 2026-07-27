export function alterandoPrimeiraLetra(palavra) {
    let texto = palavra.charAt(0).toUpperCase() + palavra.slice(1)
    return texto
}