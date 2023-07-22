export interface GolesPartidos{
  idPartido: number;
  equipoLocal: string;
  equipoVisitante: string;
  fecha: string;
  hora: string;
  autorGol: string;
  minuto: number;
}

export interface RespuestaGolesPartidos{
  golesPartidos: GolesPartidos[];
}

export interface Goleadores{
  idJugador: number;
  nombres: string;
  nombreEquipo: string;
  goles: number;
}

export interface RespuestaGoleadores{
  goleadores: Goleadores[];
}

export interface Equipo{
  idEquipo: number;
  nombre: string;
  ciudad: string;
}
