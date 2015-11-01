package com.newsweaver;

import com.newsweaver.http.ClientInterface;

import java.util.ArrayList;
import java.util.List;

public class Newsweaver {

    public static final String VERSION = "1.0";

    public static final String LIVE_API_BASE = "https://api.newsweaver.com";

    protected Config config;

    protected List<ClientInterface> clients = new ArrayList<ClientInterface>();

    protected RequestOption option;

    public Newsweaver(String username, String password, String accountCode) {
        this(new Config.Builder(username, password)
                .accountCode(accountCode)
                .build());
    }

    public Newsweaver(Config config) {
        this(config, new ArrayList<ClientInterface>());
    }

    public Newsweaver(Config config, List<ClientInterface> clients) {
        this(config, clients, new RequestOption());
    }

    public Newsweaver(Config config, List<ClientInterface> clients, RequestOption option) {
        this.config = config;
        this.clients = clients;
        this.option = option;
    }

    public Config getConfig() {
        return config;
    }

    public Newsweaver setConfig(Config config) {
        this.config = config;
        return this;
    }

    public Newsweaver pushClient(ClientInterface client) {
        this.clients.add(0, client);
        return this;
    }

    public ClientInterface popClient() {
        if (clients.isEmpty()) {
            throw new IllegalArgumentException("You tried to pop from an empty client stack");
        }
        return clients.remove(0);
    }

    public Newsweaver setClients(List<ClientInterface> clients) {
        this.clients = new ArrayList<ClientInterface>();
        for (ClientInterface client: clients) {
            this.pushClient(client);
        }
        return this;
    }

    public List<ClientInterface> getClients() {
        return clients;
    }

    public Newsweaver setOption(RequestOption option) {
        this.option = option;
        return this;
    }

    public RequestOption getOption() {
        return option;
    }
}
