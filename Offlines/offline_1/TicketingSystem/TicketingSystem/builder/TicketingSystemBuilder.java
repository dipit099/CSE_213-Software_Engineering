package TicketingSystem.builder;

import TicketingSystem.package_factory.PackageFactory;
import TicketingSystem.internet_factory.*;
import TicketingSystem.webframework_factory.*;
import TicketingSystem.TicketingSystem;

public class TicketingSystemBuilder {
    PackageFactory packageFactory;
    InternetConnection internetConnection;
    WebframeWork webframeWork;

    public void addPackage(PackageFactory packageFactory) {
        this.packageFactory = packageFactory;
    }

    public void addInternetConnection(InternetConnection internetConnection) {
        this.internetConnection = internetConnection;
    }

    public void addWebframeWork(WebframeWork webframeWork) {
        this.webframeWork = webframeWork;
    }

    public TicketingSystem assemble() {
        return new TicketingSystem(packageFactory, internetConnection, webframeWork);

    }

}
