package com.ethereumclassic.etherjar.starter.rest;


import com.ethereumclassic.etherjar.starter.ethereum.EthProxy;
import org.ethereumclassic.etherjar.model.Address;
import org.ethereumclassic.etherjar.model.HexData;
import org.ethereumclassic.etherjar.rpc.json.BlockJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@RestController
public class EthController {

    @Autowired
    EthProxy ethProxy;

    @RequestMapping(value = "/block/{id}", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public BlockJson getBlockById(@PathVariable("id") int id) throws IOException {
        return ethProxy.getBlock(id);
    }

    @RequestMapping(value = "/block/last", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Long getLastBlock() throws IOException {
        return ethProxy.getLastBlock();
    }

    @RequestMapping(value = "/hashrate/submit/{amount}", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean submitHashrate(@PathVariable("amount") String amount) throws IOException {
        return ethProxy.submitHashrate(amount);
    }

    @RequestMapping(value = "/work/submit/{nonce}", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean submitWork(@PathVariable("nonce") String nonce) throws IOException {
        return ethProxy.submitWork(nonce);
    }

    @RequestMapping(value = "/work/fetch", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public HexData[] getWork() throws IOException {
        return ethProxy.getWork();
    }

    @RequestMapping(value = "/coinbase", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address coinbase() throws IOException {
        return ethProxy.getCoinbase();
    }

    @RequestMapping(value = "/hashrate", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Long hashrate() throws IOException {
        return ethProxy.getHashrate();
    }

    @RequestMapping(value = "/isMining", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Boolean isMining() throws IOException {
        return ethProxy.isMining();
    }

    @RequestMapping(value = "/gasPrice", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Long getGasPrice() throws IOException {
        return ethProxy.getGasPrice();
    }

    @RequestMapping(value = "/accounts", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public Address[] getAccounts() throws IOException {
        return ethProxy.getAccounts();
    }

    @RequestMapping(value = "/compilers", method = GET, produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public String[] getCompilers() throws IOException {
        return ethProxy.getCompilers();
    }
}
