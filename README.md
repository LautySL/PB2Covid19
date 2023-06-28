El centro VacunARTE nos contrata para desarrollar una aplicación que nos permita llevar el
control de las vacunas que se aplican los ciudadanos de nuestro país, para luego sacar
estadísticas, de cuántas personas se vacunan al mes y a cuantas les falta alguna dosis por
aplicar.

El centro de vacunación cuenta con distintos tipos de vacunas:

● Covid-19 1er. dosis , Covid-19 2da dosis

● Hepatitis A, Hepatitis B, Hepatitis C

● Rubeola

Las personas que asisten al centro de vacunación pueden aplicarse las vacunas bajo ciertas
ciertas condiciones.

● Los pacientes al momento de su creación no cuentan con ninguna vacuna aplicada
previamente
● Se considera vacunado para el Covid-19 cuando tiene las 2 dosis aplicadas
● El paciente se podrá aplicar la 2da dosis de Covid-19 si éste ya tiene aplicada la 1er
dosis, en caso contrario se deberá lanzar NoCovidVaccineException()
● Si el paciente ya estuvo enfermo de hepatitis o rubéola, no se podrá aplicar la vacuna
de dicha enfermedad
● Los pacientes no se pueden vacunar con más de 2 vacunas distintas, para este caso
se deberá lanzar una excepción: NoMoreVaccineException()
● Un paciente no puede aplicarse dos o más veces la misma vacuna
● Se necesita poder ordenar solo a los pacientes vacunados por su DNI y al mismo
tiempo por Nombre de manera descendente.

Se requiere implementar la totalidad de las clases que den solución a la situación planteada
y al menos 5 casos de pruebas significativos.
