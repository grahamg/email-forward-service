# email-forward-service

tl;dr - Provides "email facade" addresses that can be created on demand which forward messages to a destination address. An example use case being: I want to subscribe to a mailing list, but I want to remain protected in case the address list gets sold. If that happens the "email facade" address can be disposed of and the destination address won't have to go through a questionable unsubscribe process.

An "email facade" address created on demand can be any unreserved name that hasn't yet been taken on the attached domain name, so something like a hash of characters (pofc089hj09) or a discriptive name (john.doe).

The intended target audience to use this service is someone with a private server that would want to use it for their own private use. At this point, it's not intended for a typical multi-tenant environment use case.
