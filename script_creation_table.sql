CREATE DATABASE IF NOT EXISTS car_sharing;


USE car_sharing;

-- Tabella Utenti
CREATE TABLE Utenti (
    ID_utente INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    cognome VARCHAR(255),
    email VARCHAR(255),
    password VARCHAR(255),
    numero_telefono VARCHAR(20),
    indirizzo VARCHAR(255),
    stato_attivazione_utente BOOLEAN,
    delete_flag BOOLEAN default false
);

-- Tabella Abbonamenti
CREATE TABLE Abbonamenti (
    ID_abbonamento INT AUTO_INCREMENT PRIMARY KEY,
    tipo_abbonamento ENUM("SEMESTRALE,BIENNALE,ANNUALE"),
    costo_abbonamento int(50),
    descrizione TEXT,
    delete_flag BOOLEAN default false

);

-- Tabella Tariffe
CREATE TABLE Tariffe (
    ID_tariffa INT AUTO_INCREMENT PRIMARY KEY,
    tipo_tariffa ENUM("F0","F1","F2F3"),  -- tipo di tariffa oraria x abbonamento
    costo ENUM('10','100','1000'), -- in bse al tipo di tariffa
    delete_flag BOOLEAN default false


);

-- Tabella Aziende
CREATE TABLE Aziende (
    ID_azienda INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255),
    indirizzo VARCHAR(255),
    partita_IVA VARCHAR(20),
    informazioni_contatto TEXT,
    delete_flag BOOLEAN default false
);

-- Tabella Assicurazione
CREATE TABLE Assicurazione (
    ID_assicurazione INT AUTO_INCREMENT PRIMARY KEY,
    nome_compagnia VARCHAR(255),
    numero_polizza VARCHAR(50),
    data_inizio DATE,
    data_scadenza DATE,
    tipo_copertura VARCHAR(255),
    premio int(50),
    contatto_emergenza VARCHAR(20),
    note_aggiuntive TEXT,
    delete_flag BOOLEAN default false
);
-- Tabella Mezzi
CREATE TABLE Mezzi (
    ID_mezzo INT AUTO_INCREMENT PRIMARY KEY,
    targa VARCHAR(20),
    modello VARCHAR(100),
    marca VARCHAR(100),
    anno INT,
    tipo_carburante ENUM("DIESEL,BENZINA,ELETTRICO,IBRIDO"),
    chilometraggio int,
    stato_mezzo ENUM('DISPONIBILE', 'IN_MANUTENZIONE','NON_DISPONIBILE'),
    ultima_manutenzione DATE,
    ID_azienda INT,
    ID_assicurazione INT,
    delete_flag BOOLEAN default false,
    FOREIGN KEY (ID_azienda) REFERENCES Aziende(ID_azienda),
    FOREIGN KEY (ID_assicurazione) REFERENCES Assicurazione(ID_assicurazione)
);

-- Tabella Prenotazioni
CREATE TABLE Prenotazioni (
    ID_prenotazione INT AUTO_INCREMENT PRIMARY KEY,
    data_inizio DATE,
    data_fine DATE,
    luogo_ritiro VARCHAR(255),
    luogo_riconsegna VARCHAR(255),
    costo_totale INT,
    ID_utente INT,
    ID_mezzo INT,
    ID_tariffa INT,
    delete_flag BOOLEAN default false,
    FOREIGN KEY (ID_utente) REFERENCES Utenti(ID_utente),
    FOREIGN KEY (ID_mezzo) REFERENCES Mezzi(ID_mezzo),
    FOREIGN KEY (ID_tariffa) REFERENCES Tariffe(ID_tariffa)
);

-- Tabella Fatturazione_Pagamenti
CREATE TABLE Fatturazione_Pagamenti (
    ID_fattura INT AUTO_INCREMENT PRIMARY KEY,
    ID_prenotazione INT,
    importo_totale INT,
    data_fattura DATE,
    metodo_pagamento ENUM("BANCOMAT","CONTANTI","BONIFICO"),
    stato_pagamento ENUM('PAGATO', 'NON_PAGATO','IN_ATTESA'),
    pdf_fattura VARCHAR(50),
    delete_flag BOOLEAN default false,
    FOREIGN KEY (ID_prenotazione) REFERENCES Prenotazioni(ID_prenotazione)
);
-- Tabella Manutenzione
CREATE TABLE Manutenzione (
    ID_manutenzione INT AUTO_INCREMENT PRIMARY KEY,
    ID_mezzo INT,
    ID_azienda INT,
    data_manutenzione DATE,
    tipo_manutenzione VARCHAR(100),
    costo int(50),
    note TEXT,
    delete_flag BOOLEAN default false,
    FOREIGN KEY (ID_mezzo) REFERENCES Mezzi(ID_mezzo),
    FOREIGN KEY (ID_azienda) REFERENCES Aziende(ID_azienda)
);


-- Relazioni many-to-many tra Utenti e Abbonamenti
CREATE TABLE Utenti_Abbonamenti (
    ID_utente INT,
    ID_abbonamento INT,
    PRIMARY KEY (ID_utente, ID_abbonamento),
    FOREIGN KEY (ID_utente) REFERENCES Utenti(ID_utente),
    FOREIGN KEY (ID_abbonamento) REFERENCES Abbonamenti(ID_abbonamento)
);

-- Relazioni many-to-many tra Abbonamenti e Tariffe
CREATE TABLE Abbonamenti_Tariffe (
    ID_abbonamento INT,
    ID_tariffa INT,
    PRIMARY KEY (ID_abbonamento, ID_tariffa),
    FOREIGN KEY (ID_abbonamento) REFERENCES Abbonamenti(ID_abbonamento),
    FOREIGN KEY (ID_tariffa) REFERENCES Tariffe(ID_tariffa)
);

