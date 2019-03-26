package org.pac4j.demo.dw.resources;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.glassfish.jersey.process.internal.RequestScoped;
import org.pac4j.core.config.Config;
import org.pac4j.core.profile.CommonProfile;
import org.pac4j.demo.dw.views.ProfilesView;
import org.pac4j.jax.rs.annotations.Pac4JProfile;
import org.pac4j.jax.rs.annotations.Pac4JSecurity;

import io.dropwizard.views.View;

@Path("/breaker")
@RequestScoped
public class BreakerResource {

    private final Config config;

    private final CommonProfile profile;

    @Inject
    public BreakerResource(final Config config, @Pac4JProfile final CommonProfile profile) {
        this.config = config;
        this.profile = profile;
    }

    @GET
    @Path("/index.html")
    @Pac4JSecurity(clients = "IndirectBasicAuthClient")
    public View basicauth() {
        return new ProfilesView(null);
    }
}
