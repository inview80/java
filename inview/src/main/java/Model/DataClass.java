package Model;

import lombok.*;

/**
 * Client	Asset Tag	Serial # (Asset)	Sub-model of (Model)	Name (Model.Brand)	Name (Model)	Status
 * (Asset)	Assignment	Location	Address 2 (Location)	First (User)	Name (User)	EMail (User)	ID # (User)
 * User	Cost Code	Accounting # (Other CC)	Division	City (Location)	State (Location)	ZIP (Location)	System
 * Name (IT equipment)	Non-Discoverable Reason (IT equipment)
 */
@Data
public class DataClass {
    private String client;
    private String assetTag;
    private String serialAsset;
    private String subModel;
    private String nameBrand;
    private String nameModel;
    private String statusAsset;
    private String assignment;
    private String location;
    private String addressLocation;
    private String firstUser;
    private String nameUser;
    private String emailUser;
    private String idUser;
    private String user;
    private String costCode;
    private String accountingDivision;
    private String cityLocation;
    private String stateLocation;
    private String zipLocation;
    private String system;
    private String nameITequipent;
    private String nonDiscoverableReason;


}
