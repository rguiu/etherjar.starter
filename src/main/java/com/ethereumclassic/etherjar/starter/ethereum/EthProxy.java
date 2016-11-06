package com.ethereumclassic.etherjar.starter.ethereum;

import java.net.URI;
import java.net.URISyntaxException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ethereumclassic.etherjar.model.Address;
import org.ethereumclassic.etherjar.model.HexData;
import org.ethereumclassic.etherjar.model.Hex32;
import org.ethereumclassic.etherjar.model.Nonce;
import org.ethereumclassic.etherjar.rpc.DefaultRpcClient;
import org.ethereumclassic.etherjar.rpc.JacksonRpcConverter;
import org.ethereumclassic.etherjar.rpc.json.BlockJson;
import org.ethereumclassic.etherjar.rpc.transport.DefaultRpcTransport;
import org.ethereumclassic.etherjar.rpc.transport.RpcTransport;

public class EthProxy {

    private static final Log LOG = LogFactory.getLog(EthProxy.class);

    DefaultRpcClient defaultRpcClient;
    JacksonRpcConverter converter;

    public void start() {
        try {
            RpcTransport defaultRpcTransport = new DefaultRpcTransport(
                    new URI("http://localhost:8545")
            );

            defaultRpcClient = new DefaultRpcClient(defaultRpcTransport);
            converter = new JacksonRpcConverter();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }

    public BlockJson getBlock(int n) {
        try {
            return defaultRpcClient.eth().getBlock(n, false).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long getLastBlock() {
        try {
            return defaultRpcClient.eth().getBlockNumber().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean submitHashrate(String a) {
        try {
            return defaultRpcClient.eth().submitHashrate(Hex32.from(a),
                    Hex32.from("0x59daa26581d0acd1fce254fb7e85952f4c09d0915afd33d3886cd914bc7d283c")).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean submitWork(String nonce) {
        try {
            return defaultRpcClient.eth().submitWork(Nonce.from(nonce),
                    Hex32.from("0x002440e15267eebdf06fa7fe5aee5ccff445967925a90ecce6429aef7f8feb1f"),
                    Hex32.from("0x000000000029891796c0001e696bca79de31c4640e112f147dc80e77263ffa1a")).get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public HexData[] getWork() {
        try {
            if (defaultRpcClient!=null)
                LOG.info("defaultRpcClient.eth(): " + defaultRpcClient.eth() == null );
            return defaultRpcClient.eth().getWork().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Address getCoinbase() {
        try {
            if (defaultRpcClient!=null)
                LOG.info("defaultRpcClient.eth(): " + defaultRpcClient.eth() == null );
            return defaultRpcClient.eth().getCoinbase().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long getHashrate() {
        try {
            return defaultRpcClient.eth().getHashrate().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Boolean isMining() {
        try {
            return defaultRpcClient.eth().isMining().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Long getGasPrice() {
        try {
            return defaultRpcClient.eth().getGasPrice().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Address[] getAccounts() {
        try {
            return defaultRpcClient.eth().getAccounts().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public String[] getCompilers() {
        try {
            return defaultRpcClient.eth().getCompilers().get();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}